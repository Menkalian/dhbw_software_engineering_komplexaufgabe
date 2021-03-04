import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import packagecenter.command.InitCommand;
import packagecenter.incomming.Pallet;
import packagecenter.incomming.Truck;
import packagecenter.parts.PackageSortingCenter;
import packagecenter.parts.controlling.controlunit.CentralControlUnit;
import packagecenter.parts.delivery.unloading.IAutonomousCar;
import packagecenter.parts.delivery.unloading.TruckUnloadingArea;
import packagecenter.parts.delivery.waiting.ParkingZone;
import packagecenter.parts.sortingsystem.SortingSystem;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackageCenterTest {
    private PackageSortingCenter center;

    @BeforeEach
    void setupPackageSortingCenter() {
        center = new PackageSortingCenter.Builder()
                .capacityWaitingArea(5)
                .amountUnloadingAreas(7)
                .amountAutonomousCarSpots(5)
                .build();

    }

    @Test
    @Order(1)
    void packageCenterSetupTest() {
        assertNotNull(center);

        // Check for a valid CentralControlUnit
        assertNotNull(center.getCentralControlUnit());
        assertTrue(center.getCentralControlUnit() instanceof CentralControlUnit);

        // 7 TruckUnloadingZones
        assertNotNull(center.getUnloadingAreas());
        assertEquals(7, center.getUnloadingAreas().size());

        center.getUnloadingAreas().forEach(Assertions::assertNotNull);
        center.getUnloadingAreas().forEach(area -> assertTrue(area instanceof TruckUnloadingArea));

        // ParkingZone for AutonomousCars
        assertNotNull(center.getParkingZone());
        assertTrue(center.getParkingZone() instanceof ParkingZone);

        assertDoesNotThrow(() -> {
            Field carsField = ParkingZone.class.getDeclaredField("cars");
            carsField.setAccessible(true);
            assertEquals(5, ((IAutonomousCar[]) carsField.get(center.getParkingZone())).length);
        });

        // SortingSystem
        assertNotNull(center.getSortingSystem());
        assertTrue(center.getSortingSystem() instanceof SortingSystem);

        // Check SortingSystem has no null-fields either
        assertDoesNotThrow(
                () -> Arrays.stream(center.getSortingSystem()
                                          .getClass().getDeclaredMethods())
                            .filter(method -> method.getName().startsWith("get") && method.getParameterTypes().length == 0)
                            .forEach(method -> {
                                try {
                                    Assertions.assertNotNull(method.invoke(center.getSortingSystem()));
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    // Forward so Assert does catch it.
                                    throw new RuntimeException(e);
                                }
                            })
        );
    }

    @Test
    @Order(2)
    void truckUnloadingTest() {
        // Init with the InitCommand
        new InitCommand().execute(center.getCentralControlUnit());
        Truck truck = center.getWaitingArea().getTrucks()[0];
        center.getUnloadingAreas().get(0).truckArriving(truck);

        for (Pallet pallet : truck.getTrailer().getLeftSide()) {
            assertNull(pallet);
        }
        for (Pallet pallet : truck.getTrailer().getRightSide()) {
            assertNull(pallet);
        }

        // Take two pallets from each position to verify they are there.
        center.getSortingSystem().getTempStorageArea().getPositions().forEach(pos -> assertNotNull(pos.take()));
        center.getSortingSystem().getTempStorageArea().getPositions().forEach(pos -> assertNotNull(pos.take()));
    }
}
