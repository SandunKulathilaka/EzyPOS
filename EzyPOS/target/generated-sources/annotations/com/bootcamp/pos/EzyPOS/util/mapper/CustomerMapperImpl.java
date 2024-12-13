package com.bootcamp.pos.EzyPOS.util.mapper;

import com.bootcamp.pos.EzyPOS.dto.CustomerDto;
import com.bootcamp.pos.EzyPOS.dto.response.CustomerResponseDto;
import com.bootcamp.pos.EzyPOS.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T07:39:33+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setName( dto.getName() );
        customer.setAddress( dto.getAddress() );
        customer.setSalary( dto.getSalary() );

        return customer;
    }

    @Override
    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setId( customer.getId() );
        customerResponseDto.setName( customer.getName() );
        customerResponseDto.setAddress( customer.getAddress() );
        customerResponseDto.setSalary( customer.getSalary() );

        return customerResponseDto;
    }

    @Override
    public List<CustomerResponseDto> toCustomerResponseDtoList(List<Customer> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerResponseDto> list1 = new ArrayList<CustomerResponseDto>( list.size() );
        for ( Customer customer : list ) {
            list1.add( toCustomerResponseDto( customer ) );
        }

        return list1;
    }
}
