package io.cloudstate.kotlinsupport.transcoding;

import io.cloudstate.javasupport.EntityId;

import java.lang.annotation.Annotation;

public final class EntityIdImpl implements EntityId {
    public Class<? extends Annotation> annotationType() {
        return EntityId.class;
    }
}
