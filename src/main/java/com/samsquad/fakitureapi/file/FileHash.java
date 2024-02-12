package com.samsquad.fakitureapi.file;

import com.samsquad.fakitureapi.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
