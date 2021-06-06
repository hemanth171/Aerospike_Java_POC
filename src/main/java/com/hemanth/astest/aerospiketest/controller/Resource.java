package com.hemanth.astest.aerospiketest.controller;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhello")
public class Resource {

    @GetMapping
    public <T> T sayHello() {

        AerospikeClient client = new AerospikeClient("10.176.10.180", 3000);

        Key key = new Key("test", "demo1", "putgetkey");

        Record record = client.get(null, key);

        System.out.println(record.bins.get("lineage"));

        client.close();

        return (T) record.getString("lineage");

    }
}
