package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IContactDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Contact;

@Service("contactService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class ContactService implements IContactService {
	
	@Autowired
	private IContactDao contactDao;

	@Override
	public Contact save(Contact contact) throws ServiceException {
		return contactDao.save(contact);
	}

	@Override
	public List<Contact> saveAll(List<Contact> contacts) throws ServiceException {
		return contactDao.saveAll(contacts);
	}

	@Override
	public void persist(Contact contact) throws ServiceException {
		contactDao.save(contact);
	}

	@Override
	public Contact update(Contact contact) throws ServiceException {
		return contactDao.save(contact);
		// return contactDao.getOne(contact.getContactId());
	}

	@Override
	public Collection<Contact> updateAll(Collection<Contact> contacts) throws ServiceException {
		Set<Long> contactIds = new HashSet<>();
		contacts.forEach(e -> contactIds.add(e.getContactId()));
		return contactDao.findAllById(contactIds);
	}

	@Override
	public void delete(Contact contact) throws ServiceException {
		contactDao.delete(contact);
	}

	@Override
	public void deleteAll(List<Contact> contacts) throws ServiceException {
		contactDao.deleteAll(contacts);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		contactDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> contactDao.deleteById(id));
	}

	@Override
	public Contact findById(Long id) throws ServiceException {
		Optional<Contact> contact = contactDao.findById(id);
		return contact.get();
	}

	@Override
	public List<Contact> findAll() throws ServiceException {
		return contactDao.findAll();
	}

	@Override
	public List<Contact> findByIds(List<Long> ids) throws ServiceException {
		return contactDao.findAllById(ids);
	}

}
