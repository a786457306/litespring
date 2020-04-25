package com.zzw.litespring.core.io;

public interface ResourceLoader {

    Resource getResource();

    ClassLoader getCLassLoader();
}
