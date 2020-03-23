package com.mapei.javatest.test_stream;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/25
 */
public class PathTest {
    //F:\test_file
    public static void main(String[] args) throws Exception {
        FileSystem fs = FileSystems.newFileSystem(Paths.get("F:\\test_file\\newZip.zip"), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
