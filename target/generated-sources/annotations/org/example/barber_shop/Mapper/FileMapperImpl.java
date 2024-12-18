package org.example.barber_shop.Mapper;

import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.File.FileResponse;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.User.UserResponseNoFile;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-18T23:17:19+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class FileMapperImpl implements FileMapper {

    @Override
    public FileResponse toFileResponse(File file) {
        if ( file == null ) {
            return null;
        }

        FileResponse fileResponse = new FileResponse();

        fileResponse.setOwner( userToUserResponseNoFile( file.getOwner() ) );
        if ( file.getId() != null ) {
            fileResponse.setId( file.getId().intValue() );
        }
        fileResponse.setName( file.getName() );
        fileResponse.setUrl( file.getUrl() );
        fileResponse.setThumbUrl( file.getThumbUrl() );
        fileResponse.setMediumUrl( file.getMediumUrl() );
        fileResponse.setCreatedAt( file.getCreatedAt() );
        fileResponse.setUpdatedAt( file.getUpdatedAt() );

        return fileResponse;
    }

    @Override
    public FileResponseNoOwner toFileResponseNoOwner(File file) {
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

    protected UserResponseNoFile userToUserResponseNoFile(User user) {
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
        userResponseNoFile.rank = user.getRank();
        userResponseNoFile.createdAt = user.getCreatedAt();
        userResponseNoFile.updatedAt = user.getUpdatedAt();

        return userResponseNoFile;
    }
}
