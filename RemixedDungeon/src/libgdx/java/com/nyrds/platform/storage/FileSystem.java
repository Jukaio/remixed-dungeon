package com.nyrds.platform.storage;

import com.nyrds.util.ModError;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import lombok.SneakyThrows;

public class FileSystem {

    static public File getInternalStorageFile(String fileName) {
        return new File(getRootDirectory());
    }

    static public String[] listInternalStorage() {
        File storageDir = new File(getRootDirectory());
        return storageDir.list();
    }

    @NotNull
    static public File[] listExternalStorage() {

        return null;
    }

    static public OutputStream getOutputStream(String filename) throws FileNotFoundException {
        File dir = new File(filename).getParentFile();
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        return new FileOutputStream(FileSystem.getInternalStorageFile(filename));
    }

    static public InputStream getInputStream(String filename) throws FileNotFoundException {
        return new FileInputStream(FileSystem.getInternalStorageFile(filename));
    }

    static public String getInternalStorageFileName(String fileName) {
        return getInternalStorageFile(fileName).getAbsolutePath();
    }

    static public File getExternalStorageFile(String fileName) {
        // TODO: Libgdx filesystem
        return null;
    }

    static public String getExternalStorageFileName(String fname) {
        return getExternalStorageFile(fname).getAbsolutePath();
    }

    static public File getFile(String fname) {
        return getInternalStorageFile(fname);
    }

    static public void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

    @SneakyThrows
    static public void copyStream(InputStream in, OutputStream out) {
        byte[] buffer = new byte[4096];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        in.close();

        out.flush();
        out.close();
    }

    @SneakyThrows
    static public void copyFile(String inputFile, OutputStream out) {
        InputStream in = new FileInputStream(inputFile);
        copyStream(in, out);
    }

    @SneakyThrows
    static public void copyFile(String inputFile, String outputFile) {
        File dir = new File(outputFile).getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }

        copyFile(inputFile, new FileOutputStream(outputFile));
    }

    public static void zipFolderTo(OutputStream out, File srcFolder, int depth, FileFilter filter) throws IOException {
        ZipOutputStream zip = new ZipOutputStream(out);
        addFolderToZip(srcFolder,srcFolder,depth, zip, filter);

        zip.flush();
        zip.close();
    }

    private static void addFolderToZip(File rootFolder, File srcFolder, int depth,
                                       ZipOutputStream zip, FileFilter filter) throws IOException {

        for (File file : srcFolder.listFiles(filter)) {

            if (file.isFile()) {
                addFileToZip(rootFolder, file, zip);
                continue;
            }

            if(depth > 0 && file.isDirectory()) {
                zip.putNextEntry(new ZipEntry(getRelativePath(file,rootFolder)));
                addFolderToZip(rootFolder, srcFolder, depth-1, zip, filter);
                zip.closeEntry();
            }
        }
    }

    private static void addFileToZip(File rootFolder, File file, ZipOutputStream zip) throws IOException {
        byte[] buf = new byte[4096];
        int len;
        try(FileInputStream in = new FileInputStream(file)) {
            zip.putNextEntry(new ZipEntry(getRelativePath(file, rootFolder)));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
            zip.closeEntry();
        }
    }

    public static String getRelativePath(File file, File folder) {
        String filePath = file.getAbsolutePath();
        String folderPath = folder.getAbsolutePath();
        if (filePath.startsWith(folderPath)) {
            return filePath.substring(folderPath.length() + 1);
        } else {
            return null;
        }
    }

    private static String getRootDirectory() {
        return null;
    }

    public static void ensureDir(String dir) {
        File f = new File(dir);

        if(f.exists() && f.isDirectory()){
            return;
        }

        if(f.exists() && !f.delete()) {
            throw new ModError("Can't cleanup:"+dir);
        }

        if (!f.mkdirs()) {
            throw new ModError("Can't create directory:"+dir);
        }
    }
}
