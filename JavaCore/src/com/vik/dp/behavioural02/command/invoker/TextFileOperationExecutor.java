package com.vik.dp.behavioural02.command.invoker;

import java.util.ArrayList;
import java.util.List;

import com.vik.dp.behavioural02.command.command.TextFileOperation;

public class TextFileOperationExecutor {
    
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();
    
    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
