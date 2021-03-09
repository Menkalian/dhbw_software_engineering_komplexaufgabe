import java.io.File
import kotlin.random.Random

data class Package(val id: String, var content: String, val zip_code: String, val type: PackageType, val weight: Double)
data class Box(val id: String, val packages: List<Package>)
data class Pallet(val id: Int, val boxes: List<List<Box>>)
data class Truck(val id: String, val left: Array<Pallet>, val right: Array<Pallet>)

enum class PackageType {
    NORMAL,
    EXPRESS,
    VALUE
}

fun main() {
    // some random seed e.g. matriculation numbers
    val rng = Random(26275854485500)

    val idPool = mutableListOf<Char>()
    idPool.addAll('a'..'z')
    idPool.addAll('0'..'9')

    val truckIdPool = mutableListOf<Char>()
    truckIdPool.addAll('A'..'Z')
    truckIdPool.addAll('0'..'9')

    val contentPool = mutableListOf<Char>()
    contentPool.addAll('a'..'z')
    contentPool.add('.')
    contentPool.add(':')
    contentPool.add('-')
    contentPool.add('!')

    // Packages
    val packages = hashMapOf<String, Package>()

    for (i in 0 until 24000) {
        var id: String
        do {
            id = (1..6).map { idPool.random(rng) }.joinToString("")
        } while (packages.containsKey(id))

        val zip_code = String.format("%05d", rng.nextInt(1067, 99999))
        val type = when {
            i < 19200 -> PackageType.NORMAL
            i < 22800 -> PackageType.EXPRESS
            else      -> PackageType.VALUE
        }
        val weight = rng.nextDouble(1.0, 5.0)

        var content: String
        do {
            content = (1..2500).map { contentPool.random(rng) }.joinToString("")
        } while (content.contains("exp!os:ve"))

        packages[id] = Package(id, content, zip_code, type, weight)
    }

    val packageList = packages.values.shuffled(rng)

    // Place explosives
    for (i in 0 until 4) {
        val pckg = packageList.random(rng)
        println("Placed explosive in ${pckg.id}")
        val toPlace = "exp!os:ve"
        val point = rng.nextInt(pckg.content.length - toPlace.length)
        pckg.content = pckg.content.replaceRange(point..(point + toPlace.length), toPlace)
    }

    val boxes = hashMapOf<String, Box>()
    // Boxes
    for (i in 0 until 600) {
        var id: String
        do {
            id = (1..5).map { idPool.random(rng) }.joinToString("")
        } while (boxes.containsKey(id))

        val boxPackages = packageList.subList(i * 40, i * 40 + 40)
        boxes[id] = Box(id, boxPackages)
    }
    val boxesList = boxes.values.shuffled(rng)

    val pallets = mutableListOf<Pallet>()
    // Pallets
    for (id in 0 until 50) {
        val palletBoxes = listOf(
            boxesList.subList(id * 12 + 0, id * 12 + 3),
            boxesList.subList(id * 12 + 3, id * 12 + 6),
            boxesList.subList(id * 12 + 6, id * 12 + 9),
            boxesList.subList(id * 12 + 9, id * 12 + 12)
        )
        pallets.add(Pallet(id + 1, palletBoxes))
    }

    val trucks = hashMapOf<String, Truck>()
    for (i in 0 until 5) {
        var id: String
        do {
            id = (1..4).map { truckIdPool.random(rng) }.joinToString("")
        } while (trucks.containsKey(id))

        trucks[id] = Truck(id,
                           pallets.subList(i * 10 + 0, i * 10 + 5).toTypedArray(),
                           pallets.subList(i * 10 + 5, i * 10 + 10).toTypedArray())
    }

    val basePackage = File("base_package.csv")
    basePackage.createNewFile()
    basePackage.writeText("")

    packageList.forEach { basePackage.appendText("${it.id},${it.content},${it.zip_code},${it.type},${it.weight}\n") }

    val baseBox = File("base_box.csv")
    baseBox.createNewFile()
    baseBox.writeText("")

    boxesList.forEach { box ->
        box.packages.forEach { pckg ->
            baseBox.appendText("${box.id},${pckg.id}\n")
        }
    }

    val basePallet = File("base_pallet.csv")
    basePallet.createNewFile()
    basePallet.writeText("")

    pallets.forEach {pallet ->
        pallet.boxes.forEachIndexed {position, list ->
            list.forEachIndexed { height, box ->
                basePallet.appendText("${pallet.id},$position,$height,${box.id}\n")
            }
        }
    }

    val baseTruck = File("base_truck.csv")
    baseTruck.createNewFile()
    baseTruck.writeText("")

    trucks.values.forEach {truck ->
        truck.left.forEachIndexed { pos, pallet ->
            baseTruck.appendText("${truck.id},left,$pos,${pallet.id}\n")
        }
        truck.right.forEachIndexed { pos, pallet ->
            baseTruck.appendText("${truck.id},right,$pos,${pallet.id}\n")
        }
    }
}