package uz.pdp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouse.entity.AttachmentConent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentConent, Integer> {

     Optional<AttachmentConent> findAllByAttachmentId(Integer integer);
}
