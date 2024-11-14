package org.example.barber_shop.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.barber_shop.DTO.Booking.BookingResponse;
import org.example.barber_shop.DTO.Booking.WorkScheduleResponse;
import org.example.barber_shop.DTO.BookingDetail.BookingDetailResponse;
import org.example.barber_shop.DTO.Combo.ComboResponse;
import org.example.barber_shop.DTO.File.FileResponseNoOwner;
import org.example.barber_shop.DTO.Service.ServiceResponseNoType;
import org.example.barber_shop.DTO.User.UserResponse;
import org.example.barber_shop.Entity.Booking;
import org.example.barber_shop.Entity.BookingDetail;
import org.example.barber_shop.Entity.Combo;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.Service;
import org.example.barber_shop.Entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T09:23:17+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingResponse toResponse(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingResponse bookingResponse = new BookingResponse();

        if ( booking.getId() != null ) {
            bookingResponse.id = booking.getId();
        }
        bookingResponse.status = booking.getStatus();
        bookingResponse.note = booking.getNote();
        bookingResponse.staff = userToUserResponse( booking.getStaff() );
        bookingResponse.startTime = booking.getStartTime();
        bookingResponse.endTime = booking.getEndTime();
        bookingResponse.createdAt = booking.getCreatedAt();
        bookingResponse.updatedAt = booking.getUpdatedAt();
        bookingResponse.bookingDetails = bookingDetailListToBookingDetailResponseList( booking.getBookingDetails() );

        return bookingResponse;
    }

    @Override
    public List<BookingResponse> toResponses(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<BookingResponse> list = new ArrayList<BookingResponse>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( toResponse( booking ) );
        }

        return list;
    }

    @Override
    public List<WorkScheduleResponse> toWorkScheduleResponses(List<Booking> bookings) {
        if ( bookings == null ) {
            return null;
        }

        List<WorkScheduleResponse> list = new ArrayList<WorkScheduleResponse>( bookings.size() );
        for ( Booking booking : bookings ) {
            list.add( bookingToWorkScheduleResponse( booking ) );
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

    protected UserResponse userToUserResponse(User user) {
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

    protected ServiceResponseNoType serviceToServiceResponseNoType(Service service) {
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

    protected List<ServiceResponseNoType> serviceListToServiceResponseNoTypeList(List<Service> list) {
        if ( list == null ) {
            return null;
        }

        List<ServiceResponseNoType> list1 = new ArrayList<ServiceResponseNoType>( list.size() );
        for ( Service service : list ) {
            list1.add( serviceToServiceResponseNoType( service ) );
        }

        return list1;
    }

    protected ComboResponse comboToComboResponse(Combo combo) {
        if ( combo == null ) {
            return null;
        }

        ComboResponse comboResponse = new ComboResponse();

        if ( combo.getId() != null ) {
            comboResponse.id = combo.getId();
        }
        comboResponse.name = combo.getName();
        comboResponse.description = combo.getDescription();
        comboResponse.price = combo.getPrice();
        comboResponse.estimateTime = combo.getEstimateTime();
        comboResponse.images = fileListToFileResponseNoOwnerList( combo.getImages() );
        comboResponse.services = serviceListToServiceResponseNoTypeList( combo.getServices() );
        comboResponse.createdAt = combo.getCreatedAt();
        comboResponse.updatedAt = combo.getUpdatedAt();

        return comboResponse;
    }

    protected BookingDetailResponse bookingDetailToBookingDetailResponse(BookingDetail bookingDetail) {
        if ( bookingDetail == null ) {
            return null;
        }

        BookingDetailResponse bookingDetailResponse = new BookingDetailResponse();

        if ( bookingDetail.getId() != null ) {
            bookingDetailResponse.id = bookingDetail.getId();
        }
        bookingDetailResponse.service = serviceToServiceResponseNoType( bookingDetail.getService() );
        bookingDetailResponse.combo = comboToComboResponse( bookingDetail.getCombo() );
        bookingDetailResponse.createdAt = bookingDetail.getCreatedAt();
        bookingDetailResponse.updatedAt = bookingDetail.getUpdatedAt();

        return bookingDetailResponse;
    }

    protected List<BookingDetailResponse> bookingDetailListToBookingDetailResponseList(List<BookingDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDetailResponse> list1 = new ArrayList<BookingDetailResponse>( list.size() );
        for ( BookingDetail bookingDetail : list ) {
            list1.add( bookingDetailToBookingDetailResponse( bookingDetail ) );
        }

        return list1;
    }

    protected WorkScheduleResponse bookingToWorkScheduleResponse(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        WorkScheduleResponse workScheduleResponse = new WorkScheduleResponse();

        if ( booking.getId() != null ) {
            workScheduleResponse.id = booking.getId();
        }
        workScheduleResponse.startTime = booking.getStartTime();
        workScheduleResponse.endTime = booking.getEndTime();

        return workScheduleResponse;
    }
}
