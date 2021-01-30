package com.vik.dp.behavioural02.command.command;

import com.vik.dp.behavioural02.command.receiver.TextFile;

public class SaveTextFileOperation implements TextFileOperation {
    
    private final TextFile textFile;
    
    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }
    
    @Override
    public String execute() {
        return textFile.save();
    }
}
