package com.timboektoe.fluts.io.exception;

public class FileDataReaderException  extends RuntimeException{
    /*public static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "Could not find file with the following path: ";
    public static final String PROVIDED_FILE_IS_DIRECTORY_EXCEPTION_MESSAGE =
            "You have provided a directory instead of a file. Provided path: ";*/

    public FileDataReaderException(String message) {
        super(message);
    }
}
