package models;

import play.data.validation.Constraints;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by nazaria on 3/20/2015.
 */
public class Order {

    @Id
    @Constraints.Min(1)
    public Long id;
    public Long accountId;
    public LocalDateTime createdAt;
    public List<Long> menuItems;
}
