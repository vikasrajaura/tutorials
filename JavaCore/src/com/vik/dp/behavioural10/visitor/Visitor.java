package com.vik.dp.behavioural10.visitor;

public interface Visitor {

    void visit(XmlElement xe);

    void visit(JsonElement je);
}
