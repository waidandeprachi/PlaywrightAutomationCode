package pojo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutomationRecordsRepository extends JpaRepository<AutomationRecords, Integer> {
    List<AutomationRecords> findBySize(int size);
}
