package com.spring.vendor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vendor.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class VendorController {

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId) {
        return new CloudVendor("c1", "vendor 1", "address 1", "xxxxx");
    }
}
