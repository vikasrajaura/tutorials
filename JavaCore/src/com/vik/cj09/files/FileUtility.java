package com.vik.cj09.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {

	public static void main(String[] args) {
		List<String> list = (new FileUtility()).listDocuments("abc");
		list.forEach(System.out::println);

	}

	private static final String FILE_SYSTEM = "C:/TempFileServer/";

	public List<String> listDocuments(String filePath) {
		String filesPath = FILE_SYSTEM + filePath;
		try {
			List<String> fileNames = Files.list(Paths.get(filesPath)).map(path -> path.getFileName().toString())
					.collect(Collectors.toList()); // forEach(System.out::println);
			return fileNames;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

}
