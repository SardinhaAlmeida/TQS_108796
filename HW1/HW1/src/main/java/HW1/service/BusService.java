package HW1.service;

import HW1.model.Bus;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BusService {

    public Bus getBusByBusNumber(int BusNumber);
    public List<Bus> getBuses(String origin, String destination, String date);
    public List<Bus> getAll();

}
