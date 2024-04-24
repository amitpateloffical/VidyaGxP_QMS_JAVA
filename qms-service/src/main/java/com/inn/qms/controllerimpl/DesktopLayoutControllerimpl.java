package com.inn.qms.controllerimpl;
import com.inn.qms.controller.IDesktopLayoutController;
import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutDetails;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutRequest;
import com.inn.qms.service.DesktopLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DesktopLayoutControllerimpl implements IDesktopLayoutController {

    @Autowired
    private DesktopLayoutService desktopLayoutService;

    @Override
    public DesktopLayoutDetails saveLayout(@RequestBody DesktopLayoutRequest request) {
        return desktopLayoutService.saveLayout(request);
    }

    @Override
    public DesktopLayoutDetails getDesktopLayoutById(@PathVariable Long id) {
        return desktopLayoutService.getById(id);
    }

    @Override
    public List<DesktopLayoutDetails> getAllDesktopLayouts() {
        return desktopLayoutService.getAll();
    }

    @Override
    public DesktopLayoutDetails updateDesktopLayout
            (@PathVariable Long id, @RequestBody DesktopLayoutRequest desktopLayoutRequest) {
        return desktopLayoutService.updateLayout(id, desktopLayoutRequest);
    }

    @Override
   public ResponseEntity<String> deleteLayoutDetails(@RequestBody List<Long> ids) {
       try {
           desktopLayoutService.deleteLayoutDetails(ids);
           return new ResponseEntity<>("Desktop details deleted successfully", HttpStatus.OK);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       } catch (Exception e) {
           return new ResponseEntity<>("An error occurred while deleting Desktop details", HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   @Override
    public ResponseEntity<?> findLayoutByName(@PathVariable String name) {
        try {
            DesktopLayoutDetails layout = desktopLayoutService.findLayoutByName(name);
            return ResponseEntity.ok(layout);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }
}
