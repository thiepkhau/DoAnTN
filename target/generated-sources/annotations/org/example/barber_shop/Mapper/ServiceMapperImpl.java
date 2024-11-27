package org.example.barber_shop.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.Service.ServiceRequest;
import org.example.barber_shop.DTO.Service.ServiceResponse;
import org.example.barber_shop.DTO.Service.ServiceResponseNoType;
import org.example.barber_shop.DTO.ServiceType.ServiceTypeResponseNoService;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.Service;
import org.example.barber_shop.Entity.ServiceType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T21:29:21+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service toEntity(ServiceRequest serviceRequest) {
        if ( serviceRequest == null ) {
            return null;
        }

        Service service = new Service();

        service.setName( serviceRequest.getName() );
        service.setDescription( serviceRequest.getDescription() );
        service.setPrice( serviceRequest.getPrice() );
        service.setEstimateTime( serviceRequest.getEstimateTime() );
        service.setImages( multipartFileListToFileList( serviceRequest.getImages() ) );

        return service;
    }

    @Override
    public ServiceResponse toResponse(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceResponse serviceResponse = new ServiceResponse();

        if ( service.getId() != null ) {
            serviceResponse.id = service.getId();
        }
        serviceResponse.name = service.getName();
        serviceResponse.description = service.getDescription();
        serviceResponse.price = service.getPrice();
        serviceResponse.estimateTime = service.getEstimateTime();
        serviceResponse.serviceType = serviceTypeToServiceTypeResponseNoService( service.getServiceType() );
        serviceResponse.images = fileListToFileResponseNoOwnerList( service.getImages() );
        serviceResponse.createdAt = service.getCreatedAt();
        serviceResponse.updatedAt = service.getUpdatedAt();

        return serviceResponse;
    }

    @Override
    public ServiceResponseNoType toResponseNoType(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceResponseNoType serviceResponseNoType = new ServiceResponseNoType();

        if ( service.getId() != null ) {
            serviceResponseNoType.id = service.getId();
        }
        serviceResponseNoType.name = service.getName();
        serviceResponseNoType.description = service.getDescription();
        serviceResponseNoType.price = service.getPrice();
        serviceResponseNoType.estimateTime = service.getEstimateTime();
        serviceResponseNoType.images = fileListToFileResponseNoOwnerList( service.getImages() );
        serviceResponseNoType.createdAt = service.getCreatedAt();
        serviceResponseNoType.updatedAt = service.getUpdatedAt();

        return serviceResponseNoType;
    }

    @Override
    public List<ServiceResponse> toResponseList(List<Service> services) {
        if ( services == null ) {
            return null;
        }

        List<ServiceResponse> list = new ArrayList<ServiceResponse>( services.size() );
        for ( Service service : services ) {
            list.add( toResponse( service ) );
        }

        return list;
    }

    protected File multipartFileToFile(MultipartFile multipartFile) {
        if ( multipartFile == null ) {
            return null;
        }

        File file = new File();

        file.setName( multipartFile.getName() );

        return file;
    }

    protected List<File> multipartFileListToFileList(List<MultipartFile> list) {
        if ( list == null ) {
            return null;
        }

        List<File> list1 = new ArrayList<File>( list.size() );
        for ( MultipartFile multipartFile : list ) {
            list1.add( multipartFileToFile( multipartFile ) );
        }

        return list1;
    }

    protected ServiceTypeResponseNoService serviceTypeToServiceTypeResponseNoService(ServiceType serviceType) {
        if ( serviceType == null ) {
            return null;
        }

        ServiceTypeResponseNoService serviceTypeResponseNoService = new ServiceTypeResponseNoService();

        if ( serviceType.getId() != null ) {
            serviceTypeResponseNoService.id = serviceType.getId();
        }
        serviceTypeResponseNoService.name = serviceType.getName();
        serviceTypeResponseNoService.createdAt = serviceType.getCreatedAt();
        serviceTypeResponseNoService.updatedAt = serviceType.getUpdatedAt();

        return serviceTypeResponseNoService;
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

    protected List<FileResponseNoOwner> fileListToFileResponseNoOwnerList(List<File> list) {
        if ( list == null ) {
            return null;
        }

        List<FileResponseNoOwner> list1 = new ArrayList<FileResponseNoOwner>( list.size() );
        for ( File file : list ) {
            list1.add( fileToFileResponseNoOwner( file ) );
        }

        return list1;
    }
}
