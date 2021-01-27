package com.p5.ls.web.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		String password = "p5classes";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}
}



//$2a$10$HfJ7KNBn8HLiqXsrwgPPNOoN/LlM9BImlaj1gYOiSRvmwOtnKN2lW
//$2a$10$18Yu7lC8OSBJr2tdtf9eluKR0ENenxZGNV5K4ou7hDjfOH3U29lia
//$2a$10$FdbvIveeASnICeV0dp8/aempq0cLGTn5ACiDJl8TWeVnB9VDRE1K.
//$2a$10$7UaaDJbDkq/7Rkmsg7swFeC6Gu9nG5kynMWF/YwFT5wyogf/Y6Iby
//$2a$10$Ga03nkeLPq.jpKPnHTCez.wbZta2s1HFIoWLjibg4c6J4qzGLt1by
//$2a$10$XJzn/gepcRqDKDgOX9liyupz6qRE27a1Ey6rEuTzVCYfylja7Yd2u
//$2a$10$96hdz2JeG0NuulEP9HL0aee56RLmRCtDiMWrvrUCApV2U5dUDegra
//$2a$10$U2.WuWwUhhWRtl9r2.2xz.wYxdp3jvNfxA/CFJ1Iv3AXZRwpo7bOi
//$2a$10$6OJKKCfJKZUs3FQNClHJK.c0MluLYRofustbWbE/d4ifc7aWXSgO6

