package uz.pdp.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.warehouse.entity.Attachment;
import uz.pdp.warehouse.entity.AttachmentConent;
import uz.pdp.warehouse.repository.AttachmentContentRepository;
import uz.pdp.warehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;


    public Attachment uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attachment attachment = new Attachment();
            attachment.setName(originalFilename);
            attachment.setSize(size);
            attachment.setContentType(contentType);
            Attachment savedAttachment = attachmentRepository.save(attachment);
            AttachmentConent attachmentConent = new AttachmentConent();
            attachmentConent.setBytes(file.getBytes());
            attachmentConent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentConent);
            return attachment;

        }
        return null;

    }


    public List<Attachment> getAll() {
        return attachmentRepository.findAll();
    }

    public Attachment getById(Integer id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        return byId.orElse(null);
    }

    public boolean deleteById(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Optional<AttachmentConent> optionalAttachmentConent = attachmentContentRepository.findAllByAttachmentId(id);
            if (optionalAttachmentConent.isPresent()) {
                attachmentRepository.deleteById(id);
                attachmentContentRepository.delete(optionalAttachmentConent.get());
                return true;
            }
            return false;
        }
        return false;
    }
}

