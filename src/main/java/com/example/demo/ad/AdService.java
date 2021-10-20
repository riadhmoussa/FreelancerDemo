package com.example.demo.ad;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class AdService {

    private final AdRepository adRepository;

    @SneakyThrows
    public ResponseEntity<Map<String, Object>> addAd(Ad ad) {
        adRepository.save(ad);
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("ad",ad);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }


    public ResponseEntity<Map<String,Object>> deleteAd(Long id){
        adRepository.deleteById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",null);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> getAdById(Long id){
        HashMap<String, Object> object = new HashMap<>();
        Ad ad = adRepository.findById(id).get();
        HashMap<String, Object> data = new HashMap<>();
        data.put("ad",ad);
        object.put("data",data);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String,Object>> getAdByUserId(Long id){
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        List ads = adRepository.getAdByUserId(id.toString());
        System.out.println("data ads");
        System.out.println(ads);
        object.put("data",ads);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String ,Object>> getAds(){
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",adRepository.findAll());
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
    public ResponseEntity<Map<String ,Object>> updateUp(Long id,Ad ad){
        Ad ad_update = adRepository.findById(id).get();
        ad_update = ad;
        adRepository.saveAndFlush(ad_update);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",ad_update);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
    public ResponseEntity<Map<String ,Object>> searchAd(Long id,Ad ad){
        Ad ad_update = adRepository.findById(id).get();
        ad_update = ad;
        adRepository.saveAndFlush(ad_update);
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",ad_update);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    public ResponseEntity<Map<String ,Object>>  getAllAds(@RequestBody Ad request){
        AdSpecification spec = new AdSpecification(request);
        List ads = (List) StreamSupport
                .stream(adRepository.findAll(spec).spliterator(), false)
                .map(Ad::new)
                .collect(Collectors.toList());
        HashMap<String, Object> object = new HashMap<>();
        object.put("data",ads);
        object.put("success",true);
        object.put("message","success");
        object.put("status",200);
       return  new ResponseEntity<>(object, HttpStatus.OK);
    }


}
