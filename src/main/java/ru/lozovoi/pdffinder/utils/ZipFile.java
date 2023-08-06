//package ru.lozovoi.pdffinder.utils;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//
//public class ZipFile {
//
//    public String fileZip;
//
//    public ZipFile(String fileZip) {
//        this.fileZip = fileZip;
//    }
//
//    public void unzip() throws IOException {
//        File destDir = new File(fileZip);
//
//        byte[] buffer = new byte[1024];
//        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
//        ZipEntry zipEntry = zis.getNextEntry();
//        while (zipEntry != null) {
//            while (zipEntry != null) {
//                File newFile = newFile(destDir, zipEntry);
//                if (zipEntry.isDirectory()) {
//                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
//                        throw new IOException("Failed to create directory " + newFile);
//                    }
//                } else {
//                    // fix for Windows-created archives
//                    File parent = newFile.getParentFile();
//                    if (!parent.isDirectory() && !parent.mkdirs()) {
//                        throw new IOException("Failed to create directory " + parent);
//                    }
//
//                    // write file content
//                    FileOutputStream fos = new FileOutputStream(newFile);
//                    int len;
//                    while ((len = zis.read(buffer)) > 0) {
//                        fos.write(buffer, 0, len);
//                    }
//                    fos.close();
//                }
//                zipEntry = zis.getNextEntry();
//            }
//        }
//
//        zis.closeEntry();
//        zis.close();
//    }
//}
//
