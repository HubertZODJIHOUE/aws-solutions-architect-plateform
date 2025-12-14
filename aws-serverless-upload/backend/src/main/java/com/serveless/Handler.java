package com.serveless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, Object>, Map<String, Object>>{
    private static final String BUCKET = "serveless-upload";

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> event, Context context) {

        String filename = "test.txt";
        String key = "uploads/" + LocalDate.now() + "/" + filename;

        try (S3Presigner presigner = S3Presigner.create()) {


            PutObjectRequest putRequest = PutObjectRequest.builder()
                    .bucket(BUCKET)
                    .key(key)
                    .contentType("text/plain")
                    .build();
            PutObjectPresignRequest presignRequest =
                    PutObjectPresignRequest.builder()
                            .signatureDuration(Duration.ofMinutes(5))
                            .putObjectRequest(putRequest)
                            .build();

            String url = presigner.presignPutObject(presignRequest).url().toString();

            return Map.of(
                    "statusCode", 200,
                    "body", url
            );
        }

    }
}
