package com.example.ws_back.Controller;

import com.example.ws_back.entities.Disease;
import com.example.ws_back.entities.Doctor;
import com.example.ws_back.entities.Patient;
import com.example.ws_back.entities.Room;
import com.example.ws_back.service.JenaEngine;
import org.apache.jena.rdf.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Api {
    String NS = "";
    Model model = JenaEngine.readModel("data/hospital.owl");

    @GetMapping("/doctors")
    public ResponseEntity<?> getDoctors(){
        if (model != null) {
            NS = model.getNsPrefixURI("");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/query.txt"));
        } else {
            System.out.println("Error when reading model from ontology");

            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @PostMapping("/addDoctors")
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){

        if (model != null) {
            NS = model.getNsPrefixURI("");
            JenaEngine.createInstanceOfClass(model, NS, doctor.getType(), doctor.getName());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, doctor.getName(), "age", doctor.getAge());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, doctor.getName(), "name", doctor.getName());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, doctor.getName(), "CIN", doctor.getCin());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, doctor.getName(), "phone", doctor.getPhone());
            JenaEngine.updateValueOfObjectProperty(model, NS, doctor.getName(), "takingCareOf", doctor.getTakingCareOf());

            Model owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel, "data/ourrules");
            System.out.println(doctor.toString());
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/query.txt"));

        } else {
            System.out.println("Error when reading model from ontology");

            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @PostMapping("/addPatients")
    public ResponseEntity<?> createPatient(@RequestBody Patient patient){

        if (model != null) {
            NS = model.getNsPrefixURI("");
            JenaEngine.createInstanceOfClass(model, NS, patient.getType(), patient.getName());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, patient.getName(), "age", patient.getAge());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, patient.getName(), "name", patient.getName());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, patient.getName(), "CIN", patient.getCin());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, patient.getName(), "phone", patient.getPhone());
            JenaEngine.updateValueOfObjectProperty(model, NS, patient.getName(), "suffersFrom", patient.getSuffersFrom());
            JenaEngine.updateValueOfObjectProperty(model, NS, patient.getName(), "locatedIn", patient.getLocatedIn());
            JenaEngine.updateValueOfObjectProperty(model, NS, patient.getName(), "attendedBy", patient.getAttendedBy());

            Model owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel, "data/ourrules");
            System.out.println(patient.toString());
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryPatient"));

        } else {
            System.out.println("Error when reading model from ontology");

            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @PostMapping("/addDisease")
    public ResponseEntity<?> createDisease(@RequestBody Disease disease){

        if (model != null) {
            NS = model.getNsPrefixURI("");
            JenaEngine.createInstanceOfClass(model, NS, disease.getType(), disease.getName());

            Model owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel, "data/ourrules");
            System.out.println(disease.toString());
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryDisease"));

        } else {
            System.out.println("Error when reading model from ontology");

            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @PostMapping("/addRoom")
    public ResponseEntity<?> createRoom(@RequestBody Room room){
        if(room.getContains() == null){
            room.setContains("Empty");
        }
        if (model != null) {
            NS = model.getNsPrefixURI("");
            JenaEngine.createInstanceOfClass(model, NS, room.getType(), room.getRoom_name() + "_" + room.getRoom_number());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, room.getRoom_name(), "room_name", room.getRoom_name());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, room.getRoom_name(), "room_number", room.getRoom_number());
            JenaEngine.updateValueOfDataTypeProperty(model, NS, room.getRoom_name(), "contains", room.getContains());
            Model owlInferencedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(owlInferencedModel, "data/ourrules");
            System.out.println(room.toString());
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryRoom"));

        } else {
            System.out.println("Error when reading model from ontology");

            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @GetMapping("/patients")
    public ResponseEntity<?> getPatients(){
        if (model != null) {
            NS = model.getNsPrefixURI("");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryPatient"));
        } else {
            System.out.println("Error when reading model from ontology");
            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @GetMapping("/diseases")
    public ResponseEntity<?> getDiseases(){
        if (model != null) {
            NS = model.getNsPrefixURI("");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryDisease"));
        } else {
            System.out.println("Error when reading model from ontology");
            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms(){
        if (model != null) {
            NS = model.getNsPrefixURI("");
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            return ResponseEntity.ok(JenaEngine.executeQueryFile(inferedModel,"data/queryRoom"));
        } else {
            System.out.println("Error when reading model from ontology");
            return ResponseEntity
                    .badRequest()
                    .body("Error with model");

        }
    }

}
