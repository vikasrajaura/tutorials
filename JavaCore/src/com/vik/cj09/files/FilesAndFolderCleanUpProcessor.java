package com.vik.cj09.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilesAndFolderCleanUpProcessor {

	private static final int AN_HOUR_IN_MILLIS = 60 * 60 * 1000;
	
	/* can read from properties file */
	private static final String FILES_AGE_ELIGIBLE_FOR_CLEANUP_INHOURS = "1";
	private static final String FOLDER_PATH = "C:\\TempFileServer";


	/**
	 * This method cleanup folder path folder Prepares allFilesList and
	 * allDirectoriesList, and then delete files and directories older than
	 * provided hours
	 * 
	 * @param path
	 * @param olderThanHour
	 */
	public void doCleanUp() {
		System.out.println("Entering into doCleanUp() method");
		String ploadPath = FOLDER_PATH;

		// get list of all files and directories
		List<File> listAllFilesAndDirectories = listAllFilesAndDirectories(ploadPath);

		// filter only files list
		List<File> onlyFilesList = listAllFilesAndDirectories.stream().filter(File::isFile)
				.collect(Collectors.toList());

		// filter only directories list and sort in reverse order
		List<File> onlyDirectriesList = listAllFilesAndDirectories.stream().filter(File::isDirectory)
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		int filesAgeEligibleForCleanUpInHours = Integer.parseInt(FILES_AGE_ELIGIBLE_FOR_CLEANUP_INHOURS);
		if (filesAgeEligibleForCleanUpInHours < 1)
			filesAgeEligibleForCleanUpInHours = 1;

		deleteFilesAndDirectoriesOlderThanHours(onlyFilesList, onlyDirectriesList, filesAgeEligibleForCleanUpInHours);
		System.out.println("Exiting into doCleanUp() method");
	}

	/**
	 * Delete files older than provided hours, then delete empty directories
	 * which are older than provided hours
	 * 
	 * @param allFilesList
	 *            - List<File> only files list
	 * @param allDirectriesList
	 *            - List<File> only directories list
	 * @param olderThanHour
	 *            - int hours
	 */
	private void deleteFilesAndDirectoriesOlderThanHours(List<File> allFilesList, List<File> allDirectriesList,
			int olderThanHour) {
		final long purgeTime = System.currentTimeMillis() - (olderThanHour * AN_HOUR_IN_MILLIS);

		// cleaning older files
		deleteFilesOlderThanMilliSeconds(allFilesList, purgeTime);

		// cleaning older empty directories
		deleteEmptyDirectories(allDirectriesList, purgeTime);
	}

	/**
	 * Delete files older than provided time in milliseconds
	 * 
	 * @param allFilesList
	 *            - List<File> only files list
	 * @param purgeTime
	 *            - long time in milliseconds
	 */
	private void deleteFilesOlderThanMilliSeconds(List<File> allFilesList, long purgeTime) {
		System.out.println("Entering in deleteFilesOlderThanMilliSeconds()");
		for (File file : allFilesList) {
			// delete file older than purgeTime
			if (file.isFile() && file.lastModified() < purgeTime) {
				file.delete();
			}
		}
	}

	/**
	 * Delete empty directories older than provided time in milliseconds
	 * 
	 * @param allDirectriesList
	 *            - List<File> only directories list
	 * @param purgeTime
	 *            - long time in milliseconds
	 */
	private void deleteEmptyDirectories(List<File> allDirectriesList, long purgeTime) {
		System.out.println("Entering in deleteEmptyDirectoriesOlderThanMilliSeconds()");
		for (File file : allDirectriesList) {
			// delete empty directory older than purgeTime
			if (file.isDirectory() && file.list().length == 0 && file.lastModified() < purgeTime) {
				file.delete();
			}
		}
	}

	/**
	 * This method will return all filesAndDirectoriesList on the provided path
	 * 
	 * @param path
	 *            - path of directories and files
	 * @return List<File> - all filesAndDirectoriesList
	 */
	private List<File> listAllFilesAndDirectories(String path) {
		File directory = new File(path);
		List<File> resultList = new ArrayList<>();
		File[] fList = directory.listFiles();
		if(fList!=null && fList.length>0) {
			resultList.addAll(Arrays.asList(fList));
			for (File file : fList) {
				if (file.isDirectory()) {
					resultList.addAll(listAllFilesAndDirectories(file.getAbsolutePath()));
				}
			}
		}
		return resultList;
	}
}
