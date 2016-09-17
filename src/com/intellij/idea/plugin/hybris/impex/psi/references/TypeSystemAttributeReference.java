/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.impex.psi.references;

import com.intellij.idea.plugin.hybris.impex.psi.ImpexAnyHeaderParameterName;
import com.intellij.idea.plugin.hybris.impex.psi.ImpexFullHeaderType;
import com.intellij.idea.plugin.hybris.impex.psi.ImpexHeaderLine;
import com.intellij.idea.plugin.hybris.impex.psi.ImpexHeaderTypeName;
import com.intellij.idea.plugin.hybris.type.system.model.Attribute;
import com.intellij.idea.plugin.hybris.type.system.meta.TSMetaModel;
import com.intellij.idea.plugin.hybris.type.system.meta.TSMetaProperty;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.xml.GenericAttributeValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Martin Zdarsky-Jones (martin.zdarsky@hybris.com) on 15/06/2016.
 */
class TypeSystemAttributeReference extends TypeSystemReferenceBase<ImpexAnyHeaderParameterName> {

    public TypeSystemAttributeReference(@NotNull final ImpexAnyHeaderParameterNameMixin owner) {
        super(owner);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(final boolean incompleteCode) {
        final TSMetaModel meta = getTypeSystemMeta();
        final String attributeName = getElement().getText();

        return findItemTypeReference()
            .map(PsiElement::getText)
            .map(meta::findMetaClassByName)
            .map(metaclass -> metaclass.findPropertiesByName(attributeName))
            .map(Collection::stream)
            .orElse(Stream.empty())
            .map(TSMetaProperty::getDom)
            .map(AttributeResolveResult::new)
            .toArray(ResolveResult[]::new);
    }

    private Optional<ImpexHeaderTypeName> findItemTypeReference() {
        return Optional.ofNullable(PsiTreeUtil.getParentOfType(getElement(), ImpexHeaderLine.class))
                       .map(ImpexHeaderLine::getFullHeaderType)
                       .map(ImpexFullHeaderType::getHeaderTypeName);
    }

    private static class AttributeResolveResult implements ResolveResult {

        private final Attribute myDomAttribute;

        public AttributeResolveResult(@NotNull final Attribute domAttribute) {
            myDomAttribute = domAttribute;
        }

        @Nullable
        @Override
        public PsiElement getElement() {
            final GenericAttributeValue<String> codeAttr = myDomAttribute.getQualifier();
            return codeAttr == null ? null : codeAttr.getXmlAttributeValue();
        }

        @Override
        public boolean isValidResult() {
            return getElement() != null;
        }
    }

}