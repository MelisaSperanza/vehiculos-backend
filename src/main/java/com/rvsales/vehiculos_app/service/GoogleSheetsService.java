package com.rvsales.vehiculos_app.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.util.List;
@Service
public class GoogleSheetsService {

    private static final String APPLICATION_NAME = "VehiculosApp";
    private static final String SPREADSHEET_ID = "1rWSReczLZ-ohSHIJIL_Cml-jND9l3KedPsmlYm-qLWY";
    private static final String RANGE = "Vehiculos!B1:AC654";

    private Sheets sheetsService;

    public GoogleSheetsService() {
        try {
            var credentials = ServiceAccountCredentials.fromStream(
                    new FileInputStream("credentials//voltaic-spider-463009-c2-6129e45e69b6.json"))
                    .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets.readonly"));

            sheetsService = new Sheets.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(),
                    new HttpCredentialsAdapter(credentials))
                    .setApplicationName(APPLICATION_NAME)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Error inicializando Google Sheets Service", e);
        }
    }

    public List<List<Object>> leerVehiculos() throws Exception {
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, RANGE)
                .execute();
        return response.getValues();
    }
}
