package uz.pdp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.warehouse.entity.Attachment;
import uz.pdp.warehouse.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseEntity<?> add(@RequestBody MultipartHttpServletRequest request) throws IOException {
        Attachment attachment = attachmentService.uploadFile(request);
        return ResponseEntity.status(attachment != null ? 202 : 409).body(attachment);
    }

    @GetMapping(value = "/info")
    public ResponseEntity<?> getAll() {
        List<Attachment> all = attachmentService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/info/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Attachment attachment = attachmentService.getById(id);
        return ResponseEntity.status(attachment != null ? 200 : 409).body(attachment);
    }

    @GetMapping(value = "/download/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
       attachmentService.downloadFile(id,response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        boolean deleteById = attachmentService.deleteById(id);
        if (deleteById)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();

    }

}
