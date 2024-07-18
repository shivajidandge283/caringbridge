package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.User;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.BlobInfo;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private final IUserRepository userRepository;

    @Value("${gcp.bucket.name}")
    private String bucketName;

    private final Storage storage = StorageOptions.getDefaultInstance().getService();


    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByMobileNumber(phoneNumber);
    }

    public boolean checkIfEmailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        }catch (Exception exception) {
            log.error("Exception occurred while saving User ", exception.getCause());
        }
        return null;
    }

    public boolean findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return null != user ? true : false;
    }

    public User updateUser(User user) {
        if(null != user.getId()) {
            return userRepository.save(user);
        }
        return null;
    }


    public String uploadFile(MultipartFile file) throws IOException {
        String blobName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(bucketName, blobName).build(),
                file.getBytes()
        );

        return blobInfo.getMediaLink();
    }
}
