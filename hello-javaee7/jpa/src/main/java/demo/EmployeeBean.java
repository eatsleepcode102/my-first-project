/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package demo;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.Serializable;

/**
 * @author Arun Gupta
 */
@Named
@SessionScoped
public class EmployeeBean implements Serializable {

	@PostConstruct
	public void init() {
		this.currentEmp = em.createNamedQuery("Employee.findAll", Employee.class).getResultList()
				.get(new Random().nextInt(8));
	}

	@PersistenceContext
	private EntityManager em;

	List<Employee> listResults;

	private Employee currentEmp;

	public Employee getCurrentEmp() {
		return currentEmp;
	}

	public void setCurrentEmp(Employee currentEmp) {
		this.currentEmp = currentEmp;
	}

	public List<Employee> getAllEmp() {
		if (listResults == null)
			listResults = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
		return listResults;
	}

	public void getJumpRandom() {
		this.currentEmp = listResults.get(new Random().nextInt(8));
	}

	private int keyword;

	public int getKeyword() {
		return keyword;
	}

	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}

	public void onChangeKeyWord() throws ValidatorException {
		this.currentEmp = listResults.get(keyword - 1);
	}

	public void keywordValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (Integer.parseInt(value + "") > 9) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect name length",
					"Name length must <= 8, found only " + value));
		}
	}
}
