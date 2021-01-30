package com.vik.dp.behavioural02.command.client;

import com.vik.dp.behavioural02.command.command.OpenTextFileOperation;
import com.vik.dp.behavioural02.command.command.SaveTextFileOperation;
import com.vik.dp.behavioural02.command.command.TextFileOperation;
import com.vik.dp.behavioural02.command.invoker.TextFileOperationExecutor;
import com.vik.dp.behavioural02.command.receiver.TextFile;

public class TextFileApplication {
    
    public static void main(String[] args) {
        
        TextFileOperation openTextFileOperation = new OpenTextFileOperation(new TextFile("file1.txt"));
        TextFileOperation saveTextFileOperation = new SaveTextFileOperation(new TextFile("file2.txt"));
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        System.out.println(textFileOperationExecutor.executeOperation(openTextFileOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveTextFileOperation));
    }   
}
