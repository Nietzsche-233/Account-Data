package tcu.data.Main;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("account")
public class Account {
    @Id
    private String id;
    private String type;
    private double money;
    private String title;
    private String date;
    private boolean editable;
    public Account() {

    }
}
