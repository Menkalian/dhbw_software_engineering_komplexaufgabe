package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.config.Configuration;
import packagecenter.incomming.Package;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class Scanner implements IScanner {
    private Object scannerAlgorithmPort;

    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        try {
            String jarPath =
                    switch (algorithm) {
                        case BOYER_MOORE -> Configuration.INSTANCE.boyerMooreJarPath;
                        case RABIN_KARP -> Configuration.INSTANCE.rabinKarpJarPath;
                    };

            Manifest manifest = new JarFile(new File(jarPath), false).getManifest();
            String mainClass = manifest.getMainAttributes().getValue("Main-Class");

            URL[] urls = {new File(jarPath).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, getClass().getClassLoader());
            Class<?> clazz = Class.forName(mainClass, true, urlClassLoader);
            Object instance = clazz.getMethod("getInstance").invoke(clazz);
            scannerAlgorithmPort = clazz.getDeclaredField("port").get(instance);

            Object version = scannerAlgorithmPort.getClass().getDeclaredMethod("getVersion").invoke(scannerAlgorithmPort);
            System.out.printf("Scanner was loaded in version '%s'\n", version.toString());
        } catch (Exception ex) {
            System.err.println("Could not load Component for " + algorithm + ". Unloading components instead");
            ex.printStackTrace();
            scannerAlgorithmPort = null;
        }
    }

    public boolean scan(Package pkg) {
        String explosive = "exp!os:ve";

        try {
            int position = (int) scannerAlgorithmPort
                    .getClass()
                    .getDeclaredMethod("scan", String.class, char[][][].class)
                    .invoke(scannerAlgorithmPort, explosive, pkg.getContent());
            return position != -1;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void unloadScanComponent() {
        scannerAlgorithmPort = null;
    }
}