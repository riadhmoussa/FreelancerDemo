package com.example.demo.ad;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping(path = "api/user/ad", headers="Accept=*/*",  produces="application/json")
@AllArgsConstructor
public class AdController {

    private AdService adService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> addAd (@RequestBody Ad request){
        return adService.addAd(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteAd (@PathVariable(value = "id") Long id){
        return adService.deleteAd(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAdById (@PathVariable(value = "id") Long id){
        return adService.getAdById(id);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAds (){
        return adService.getAds();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAd (@PathVariable(value = "id") Long id,@RequestBody Ad request){
        return adService.updateUp(id,request);
    }

    @PostMapping("/search")
    public ResponseEntity<Map<String ,Object>> searchCustomers(@RequestBody Ad request) {
        return adService.getAllAds(request);
    }
}
