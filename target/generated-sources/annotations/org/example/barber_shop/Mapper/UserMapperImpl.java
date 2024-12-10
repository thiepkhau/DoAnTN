package org.example.barber_shop.Mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.User.RegisterRequest;
import org.example.barber_shop.DTO.User.StaffResponse;
import org.example.barber_shop.DTO.User.UserResponse;
import org.example.barber_shop.DTO.User.UserResponseNoFile;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T09:47:45+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( registerRequest.name );
        if ( registerRequest.dob != null ) {
            user.setDob( new Date( registerRequest.dob.getTime() ) );
        }
        user.setPhone( registerRequest.phone );
        user.setPassword( registerRequest.password );
        user.setEmail( registerRequest.email );

        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( user.getId() != null ) {
            userResponse.id = user.getId().intValue();
        }
        userResponse.name = user.getName();
        userResponse.email = user.getEmail();
        userResponse.phone = user.getPhone();
        userResponse.dob = user.getDob();
        userResponse.avatar = fileToFileResponseNoOwner( user.getAvatar() );
        userResponse.verified = user.isVerified();
        userResponse.blocked = user.isBlocked();
        userResponse.role = user.getRole();
        userResponse.createdAt = user.getCreatedAt();
        userResponse.updatedAt = user.getUpdatedAt();

        return userResponse;
    }

    @Override
    public List<UserResponse> toResponses(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public UserResponseNoFile toResponseNoFile(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseNoFile userResponseNoFile = new UserResponseNoFile();

        if ( user.getId() != null ) {
            userResponseNoFile.id = user.getId().intValue();
        }
        userResponseNoFile.name = user.getName();
        userResponseNoFile.email = user.getEmail();
        userResponseNoFile.phone = user.getPhone();
        userResponseNoFile.dob = user.getDob();
        userResponseNoFile.verified = user.isVerified();
        userResponseNoFile.blocked = user.isBlocked();
        userResponseNoFile.role = user.getRole();
        userResponseNoFile.createdAt = user.getCreatedAt();
        userResponseNoFile.updatedAt = user.getUpdatedAt();

        return userResponseNoFile;
    }

    @Override
    public StaffResponse toStaffResponse(User user) {
        if ( user == null ) {
            return null;
        }

        StaffResponse staffResponse = new StaffResponse();

        if ( user.getId() != null ) {
            staffResponse.id = user.getId().intValue();
        }
        staffResponse.name = user.getName();
        staffResponse.email = user.getEmail();
        staffResponse.phone = user.getPhone();
        staffResponse.dob = user.getDob();
        staffResponse.avatar = fileToFileResponseNoOwner( user.getAvatar() );
        staffResponse.verified = user.isVerified();
        staffResponse.blocked = user.isBlocked();
        staffResponse.role = user.getRole();
        staffResponse.createdAt = user.getCreatedAt();
        staffResponse.updatedAt = user.getUpdatedAt();

        return staffResponse;
    }

    @Override
    public List<StaffResponse> toStaffResponses(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<StaffResponse> list = new ArrayList<StaffResponse>( users.size() );
        for ( User user : users ) {
            list.add( toStaffResponse( user ) );
        }

        return list;
    }

    protected FileResponseNoOwner fileToFileResponseNoOwner(File file) {
        if ( file == null ) {
            return null;
        }

        FileResponseNoOwner fileResponseNoOwner = new FileResponseNoOwner();

        if ( file.getId() != null ) {
            fileResponseNoOwner.id = file.getId().intValue();
        }
        fileResponseNoOwner.name = file.getName();
        fileResponseNoOwner.url = file.getUrl();
        fileResponseNoOwner.thumbUrl = file.getThumbUrl();
        fileResponseNoOwner.mediumUrl = file.getMediumUrl();
        fileResponseNoOwner.createdAt = file.getCreatedAt();
        fileResponseNoOwner.updatedAt = file.getUpdatedAt();

        return fileResponseNoOwner;
    }
}
