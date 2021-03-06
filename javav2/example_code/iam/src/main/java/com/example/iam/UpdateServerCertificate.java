/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.example.iam;
import software.amazon.awssdk.core.regions.Region;
import software.amazon.awssdk.services.iam.IAMClient;
import software.amazon.awssdk.services.iam.model.UpdateServerCertificateRequest;
import software.amazon.awssdk.services.iam.model.UpdateServerCertificateResponse;

/**
 * Updates a server certificate name
 */
public class UpdateServerCertificate {
    public static void main(String[] args) {

        final String USAGE =
            "To run this example, supply the current certificate name and\n" +
            "a new name. Ex:\n\n" +
            "UpdateServerCertificate <current-name> <new-name>\n";

        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String cur_name = args[0];
        String new_name = args[1];

        Region region = Region.AWS_GLOBAL;
        IAMClient iam = IAMClient.builder().region(region).build();

        UpdateServerCertificateRequest request =
            UpdateServerCertificateRequest.builder()
                .serverCertificateName(cur_name)
                .newServerCertificateName(new_name)
                .build();

        UpdateServerCertificateResponse response =
            iam.updateServerCertificate(request);

        System.out.printf("Successfully updated server certificate to name %s",
                new_name);
    }
}

