package com.example.javazipandunzip.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipHelper {
    public void unzip(File zippedFile) throws IOException {
        File destDir = new File("extractto");
        byte[] buffer = new byte[2048];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zippedFile));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            if (zipEntry.isDirectory()) {
                continue;
            } else {
                File newFile = new File("extractto/" + zipEntry.getName());
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }
}
