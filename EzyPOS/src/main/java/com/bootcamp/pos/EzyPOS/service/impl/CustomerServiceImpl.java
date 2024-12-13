package com.bootcamp.pos.EzyPOS.service.impl;

import com.bootcamp.pos.EzyPOS.dto.CustomerDto;
import com.bootcamp.pos.EzyPOS.dto.request.CustomerRequestDto;
import com.bootcamp.pos.EzyPOS.dto.response.CustomerResponseDto;
import com.bootcamp.pos.EzyPOS.dto.response.paginate.PaginatedCustomerResponseDto;
import com.bootcamp.pos.EzyPOS.entity.Customer;
import com.bootcamp.pos.EzyPOS.repo.CustomerRepo;
import com.bootcamp.pos.EzyPOS.service.CustomerService;
import com.bootcamp.pos.EzyPOS.util.IdGenerator;
import com.bootcamp.pos.EzyPOS.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    // Exception
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerRequestDto dto) {
        CustomerDto cDto = new CustomerDto(idGenerator.generateId(10), dto.getName(), dto.getAddress(), dto.getSalary());
        System.out.println(customerMapper.toCustomer(cDto));
        return customerRepo.save(customerMapper.toCustomer(cDto)).getId()+ " Saved!";
    }

    @Override
    public CustomerResponseDto findCustomer(String id) throws ClassNotFoundException {
        Optional<Customer> byId = customerRepo.findById(id);
        if (byId.isPresent()){
            return customerMapper.toCustomerResponseDto(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException {
        Optional<Customer> byId = customerRepo.findById(id);
        if (byId.isPresent()){
            byId.get().setName(dto.getName());
            byId.get().setAddress(dto.getAddress());
            byId.get().setSalary(dto.getSalary());
            customerRepo.save(byId.get());
            return byId.get().getName() + " was Updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return id + " was deleted!";
    }

    @Override
    public PaginatedCustomerResponseDto findAllCustomers(
            String searchText, int page, int size
    ) {

        // create method with a custom query=? (find data)
        // create method with a custom query=? (count)
        return new PaginatedCustomerResponseDto(
                customerRepo.countCustomer(searchText),
                customerMapper.toCustomerResponseDtoList(customerRepo.searchCustomer(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }
}
