package pl.fintech.metissociallending.metissociallendingservice.domain.clock;

import java.util.Date;

public interface ClockService {
    Date getTime();
    void addDays(int days);
}
