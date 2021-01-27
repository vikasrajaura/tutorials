package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IAddressDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Address;

@Service("addressService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressDao addressDao;

	@Override
	public Address save(Address address) throws ServiceException {
		return addressDao.save(address);
	}

	@Override
	public List<Address> saveAll(List<Address> addresses) throws ServiceException {
		return addressDao.saveAll(addresses);
	}

	@Override
	public void persist(Address address) throws ServiceException {
		addressDao.save(address);
	}

	@Override
	public Address update(Address address) throws ServiceException {
		return addressDao.save(address);
		// return addressDao.getOne(address.getAddressId());
	}

	@Override
	public Collection<Address> updateAll(Collection<Address> addresses) throws ServiceException {
		Set<Long> addressIds = new HashSet<>();
		addresses.forEach(e -> addressIds.add(e.getAddressId()));
		return addressDao.findAllById(addressIds);
	}

	@Override
	public void delete(Address address) throws ServiceException {
		addressDao.delete(address);
	}

	@Override
	public void deleteAll(List<Address> addresses) throws ServiceException {
		addressDao.deleteAll(addresses);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		addressDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> addressDao.deleteById(id));
	}

	@Override
	public Address findById(Long id) throws ServiceException {
		Optional<Address> address = addressDao.findById(id);
		return address.get();
	}

	@Override
	public List<Address> findAll() throws ServiceException {
		return addressDao.findAll();
	}

	@Override
	public List<Address> findByIds(List<Long> ids) throws ServiceException {
		return addressDao.findAllById(ids);
	}

}
