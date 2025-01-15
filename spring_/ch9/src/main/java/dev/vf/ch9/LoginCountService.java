package dev.vf.ch9;

import org.springframework.stereotype.Service;

@Service
public class LoginCountService {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
