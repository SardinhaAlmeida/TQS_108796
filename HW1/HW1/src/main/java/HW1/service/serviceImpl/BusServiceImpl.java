package HW1.service.serviceImpl;

import HW1.model.Bus;
import HW1.service.BusService;
import HW1.repository.BusRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus getBusByBusNumber(int BusNumber){
        return busRepository.findByBusNumber(BusNumber);
    }

    @Override
    public List<Bus> getBuses(String origin, String destination, String date) {
        return busRepository.findByOriginAndDestinationAndDate(origin, destination, date);
    }

    @Override
    public List<Bus> getAll() {
        return busRepository.findAll();
    }

}
