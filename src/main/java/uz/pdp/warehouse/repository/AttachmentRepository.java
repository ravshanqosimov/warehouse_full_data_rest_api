package uz.pdp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.warehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {


}
