package springframework.sfgpetclinic.model;

import org.springframework.stereotype.Service;

@Service
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
