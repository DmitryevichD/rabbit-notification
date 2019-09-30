package by.dm13y.example.rabbitnotification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private int attemptNumber;
    private String message;
}
