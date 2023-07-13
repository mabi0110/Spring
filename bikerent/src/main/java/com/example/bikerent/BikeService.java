package com.example.bikerent;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public void add(BikeDto bikeDto){
        Bike bike = new Bike(
                bikeDto.getId(),
                bikeDto.getModel(),
                bikeDto.getNumberNo(),
                bikeDto.getHourPrice(),
                bikeDto.getDayPrice());
        bikeRepository.save(bike);
    }

    public void deleteById(Long bikeId){
        bikeRepository.deleteById(bikeId);
    }

    public double rentForHours(Long bikeId, int hours, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(bikeId, borrowerId, dateOfReturn);
        return bike.getHourPrice() * hours;
    }

    public double rentForDay(Long bikeId, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().withHour(23).withMinute(59);
        Bike bike = updateBike(bikeId, borrowerId, dateOfReturn);
        return bike.getDayPrice();
    }

    private Bike updateBike(Long bikeId, String borrowerId, LocalDateTime dateOfReturn) {
        Bike bike = bikeRepository.findById(bikeId)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDateOfReturn(dateOfReturn);
        bike.setBorrowerId(borrowerId);
        bikeRepository.save(bike);
        return bike;
    }


}
