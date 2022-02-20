package com.example.contractmanagementsystem.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Properties 
{

    @Value("${chunkuploadpath}")
    private String chunkuploadpath;

}
