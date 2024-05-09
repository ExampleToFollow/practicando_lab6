package com.example.practicando_lab6.Repository;

import com.example.practicando_lab6.Entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer>  {
}
